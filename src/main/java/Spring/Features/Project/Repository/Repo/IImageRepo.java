package Spring.Features.Project.Repository.Repo;

import Spring.Features.Project.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepo extends JpaRepository<Image, Long> {
}
