package com.electionpredictor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.electionpredictor.file.FileHandler;
import com.electionpredictor.instance.Election;
import com.electionpredictor.instance.Instance;
import com.electionpredictor.instance.PartyID;
import com.electionpredictor.predictors.ElectionRange;
import com.electionpredictor.predictors.PartyRange;
import com.electionpredictor.predictors.Prediction;
import com.electionpredictor.ui.Application;

/**
 * Get the ball rolling!
 * 
 * @author Niels Stchedroff
 */
public class KickOff
{
	private static final String AP = "ap";
	private static final String F = "f";
	private static final String L = "l";
	private static Options mOptions;
	private static final String P1 = "p1";
	private static final String P2 = "p2";
	private static final int PARTY_RANGE_ARGUMENT_COUNT = 4;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException
	{
		if ((args == null) || (args.length == 0))
		{
			Application.runApplication();
		}
		else
		{
			KickOff.runFromCommandLine(args);
		}
	}

	private static PartyRange buildRangeFromOption(final Instance inst, final Option option)
	{
		if (inst == null) { throw new IllegalArgumentException("Instance is null!"); }

		if (option == null) { throw new IllegalArgumentException("Option is null!"); }

		final String[] values = option.getValues();
		PartyRange result;
		PartyID partyName = null;
		double min = 0.0;
		double max = 0.0;
		int intervals = 0;

		if ((values == null) || (values.length != KickOff.PARTY_RANGE_ARGUMENT_COUNT)) { throw new IllegalArgumentException("Option "
		        + option.getOpt() + " must have " + option.getArgs() + " arguments"); }

		try
		{
			partyName = PartyID.valueOf(option.getValues()[0]);
		}
		catch (final IllegalArgumentException exp)
		{
			throw new IllegalArgumentException("Option " + option.getOpt() + " must have a valid party - value was " + option.getValues()[0], exp);
		}

		try
		{
			min = Double.valueOf(option.getValues()[1]);
		}
		catch (final NumberFormatException numExp)
		{
			throw new NumberFormatException("Party " + partyName + " must have a valid number for minimum support! '" + option.getValues()[1]
			        + "' is not valid.");
		}

		try
		{
			max = Double.valueOf(option.getValues()[2]);
		}
		catch (final NumberFormatException numExp2)
		{
			throw new NumberFormatException("Party " + partyName + " must have a valid number for maximum support! '" + option.getValues()[2]
			        + "' is not valid.");
		}

		try
		{
			intervals = Integer.valueOf(option.getValues()[3]);
		}
		catch (final NumberFormatException numExp2)
		{
			throw new NumberFormatException("Party " + partyName + " must have a valid number for intervals! '" + option.getValues()[3]
			        + "' is not valid.");
		}

		if (min < 0) { throw new IllegalArgumentException("Party " + partyName + " must have a positive minimum support!"); }

		if (max < min) { throw new IllegalArgumentException("Party " + partyName + " must have a max that is greater than min!"); }

		if ((min > 100) || (max > 100)) { throw new IllegalArgumentException("Party " + partyName + " must have max and imn that are less than 100%!"); }

		if (intervals < 0) { throw new IllegalArgumentException("Party " + partyName + " must have a number of intervals that is non-zero!"); }

		result = new PartyRange(inst.getParty(partyName), min / 100, max / 100, intervals);

		return result;
	}

	private static PartyID getPartyFromOption(final Option option)
	{
		if (option == null) { throw new IllegalArgumentException("Option is null!"); }

		final String[] values = option.getValues();
		PartyID partyName = null;

		if ((values == null) || (values.length != 1)) { throw new IllegalArgumentException("Option " + option.getOpt() + " must have "
		        + option.getArgs() + " arguments"); }

		try
		{
			partyName = PartyID.valueOf(option.getValues()[0]);
		}
		catch (final IllegalArgumentException exp)
		{
			throw new IllegalArgumentException("Option " + option.getOpt() + " must have a valid party - value was " + option.getValues()[0], exp);
		}

		return partyName;
	}

	private static void runFromCommandLine(final String[] args) throws IOException
	{
		KickOff.setupArguments();
		final Instance instance = new Instance(new Application());
		final CommandLineParser parser = new BasicParser();
		PartyRange partyA = null;
		PartyRange partyB = null;
		PartyID adjustmentParty = null;
		String filePath = null;
		String dataDirectory = null;

		try
		{
			final CommandLine cmd = parser.parse(KickOff.mOptions, args);
			final Option[] options = cmd.getOptions();

			for (final Option option : options)
			{
				if (option.getOpt().equalsIgnoreCase(KickOff.P1))
				{
					partyA = KickOff.buildRangeFromOption(instance, option);
				}

				if (option.getOpt().equalsIgnoreCase(KickOff.P2))
				{
					partyB = KickOff.buildRangeFromOption(instance, option);
				}

				if (option.getOpt().equalsIgnoreCase(KickOff.AP))
				{
					adjustmentParty = KickOff.getPartyFromOption(option);
				}

				if (option.getOpt().equalsIgnoreCase(KickOff.F))
				{
					filePath = option.getValue();
				}

				if (option.getOpt().equalsIgnoreCase(KickOff.L))
				{
					dataDirectory = option.getValue();
				}
			}

			final Election election = (Election) instance.readElection(dataDirectory, dataDirectory);
			final List<PartyRange> parties = new ArrayList<PartyRange>();
			parties.add(partyA);
			parties.add(partyB);

			final ElectionRange er = new ElectionRange(instance, election, parties, instance.getParty(adjustmentParty));

			final ArrayList<String[]> results = instance.buildAddativeModelRangeData(null, er, null);

			results.add(0, Prediction.displayPredictionHeader(instance.getPartyStore().getPartyList()));

			FileHandler.writeDataToFile(filePath, results);
		}
		catch (final ParseException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Construct the arguments for the command line
	 */
	private static void setupArguments()
	{
		// create Options object
		KickOff.mOptions = new Options();
		KickOff.mOptions.addOption(OptionBuilder.hasArgs(KickOff.PARTY_RANGE_ARGUMENT_COUNT).isRequired().withValueSeparator(',').withDescription(
		        "party 1 name").create(KickOff.P1));
		KickOff.mOptions.addOption(OptionBuilder.hasArgs(KickOff.PARTY_RANGE_ARGUMENT_COUNT).isRequired().withValueSeparator(',').withDescription(
		        "party 2 name").create(KickOff.P2));
		KickOff.mOptions.addOption(OptionBuilder.hasArgs(1).isRequired().withValueSeparator(',').withDescription("adjument party name").create(
		        KickOff.AP));
		KickOff.mOptions.addOption(OptionBuilder.hasArgs(1).isRequired().withValueSeparator(',').withDescription("output file name")
		        .create(KickOff.F));
		KickOff.mOptions.addOption(OptionBuilder.hasArgs(1).isRequired().withValueSeparator(',').withDescription("last election").create(KickOff.L));
	}

}
