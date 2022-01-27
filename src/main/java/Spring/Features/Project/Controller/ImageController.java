package Spring.Features.Project.Controller;

import Spring.Features.Project.Models.Image;
import Spring.Features.Project.Service.Interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ImageController {

    @Autowired
    IImageService service;


    // Upload Image
    // We will use a MultipartFile to upload our images. Uploading will return the imageId we can use to download the image later.
    @PostMapping
    Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
        Image dbImage = new Image();
        dbImage.setName(multipartImage.getName());
        dbImage.setImageContent(multipartImage.getBytes());

        return service.save(dbImage)
                .getId();
    }

    // The imageId path variable contains the id that was generated at upload. If an invalid id is provided,
    // then we're using ResponseStatusException to return an HTTP response code 404 (Not Found).
    // Otherwise, we're wrapping the stored file bytes in a ByteArrayResource which allows them to be downloaded.
    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable Long imageId) {
        byte[] image = service.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getImageContent();

        return new ByteArrayResource(image);
    }
}
