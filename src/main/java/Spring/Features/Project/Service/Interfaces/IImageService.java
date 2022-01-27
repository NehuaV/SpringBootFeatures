package Spring.Features.Project.Service.Interfaces;

import Spring.Features.Project.Models.Image;

import java.util.Optional;

public interface IImageService {
    Image save(Image image);
    Optional<Image> findById(Long id);
}
