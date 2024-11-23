package fit.com.Bai9.repositories;

import java.util.List;

import fit.com.Bai9.entity.DeTai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeTaiRepository extends JpaRepository<DeTai, String>  {
	public List<DeTai> findDeTaiByGiangVien_MaGV(String maGV);

}
