package Spring.Features.Project.Service;

import Spring.Features.Project.Models.Image;
import Spring.Features.Project.Repository.DAL.Interfaces.IImageDAL;
import Spring.Features.Project.Service.Interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService {

    @Autowired
    IImageDAL dal;

    @Override
    public Image save(Image image) {
        return dal.save(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return dal.findById(id);
    }
}
