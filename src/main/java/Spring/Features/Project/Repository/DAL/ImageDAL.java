package Spring.Features.Project.Repository.DAL;


import Spring.Features.Project.Models.Image;
import Spring.Features.Project.Repository.DAL.Interfaces.IImageDAL;
import Spring.Features.Project.Repository.Repo.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ImageDAL implements IImageDAL {

    @Autowired
    IImageRepo repo;

    @Override
    public Image save(Image image) {
        return repo.save(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return repo.findById(id);
    }
}
