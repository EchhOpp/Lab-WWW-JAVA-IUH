package fit.com.Bai9.repositories;

import fit.com.Bai9.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String>{
	
}
