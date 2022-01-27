package Spring.Features.Project.Repository.DAL.Interfaces;

import Spring.Features.Project.Models.Image;

import java.util.Optional;

public interface IImageDAL {
    Image save (Image image);
    Optional<Image> findById(Long id);
}
