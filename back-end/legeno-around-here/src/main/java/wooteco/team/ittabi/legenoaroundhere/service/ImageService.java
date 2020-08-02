package wooteco.team.ittabi.legenoaroundhere.service;

import java.io.IOException;
import java.util.List;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import wooteco.team.ittabi.legenoaroundhere.aws.S3Uploader;
import wooteco.team.ittabi.legenoaroundhere.domain.Image;
import wooteco.team.ittabi.legenoaroundhere.domain.ImageExtension;
import wooteco.team.ittabi.legenoaroundhere.domain.Post;
import wooteco.team.ittabi.legenoaroundhere.exception.NotImageMimeTypeException;
import wooteco.team.ittabi.legenoaroundhere.repository.ImageRepository;

@Transactional
@Service
public class ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);


    public static final String IMAGE_TYPE = "image";
    public static final String IMAGE_DIR = "images";

    private final ImageRepository imageRepository;
    private final S3Uploader s3Uploader;

    public ImageService(ImageRepository imageRepository, S3Uploader s3Uploader) {
        this.imageRepository = imageRepository;
        this.s3Uploader = s3Uploader;
    }

    public Image save(MultipartFile multipartFile, Post post) {
        validateImage(multipartFile);
        String imageUrl = s3Uploader.upload(multipartFile, IMAGE_DIR);
        Image image = new Image(multipartFile.getName(), imageUrl, post);
        return imageRepository.save(image);
    }

    private void validateImage(MultipartFile multipartFile) {
        ImageExtension.validateImageExtension(multipartFile);
        validateImageMimeType(multipartFile);
    }

    private void validateImageMimeType(MultipartFile multipartFile) {
        try {
            if (isNotImageMimeType(multipartFile)) {
                throw new NotImageMimeTypeException(
                    multipartFile.getName() + " 파일은 이미지 MIME 타입이 아닙니다!");
            }
        } catch (IOException e) {
            logger.info("의 바이트 파일을 가져오는데 실패했습니다!");
        }
    }

    private boolean isNotImageMimeType(MultipartFile multipartFile) throws IOException {
        Tika tika = new Tika();
        return !tika.detect(multipartFile.getBytes())
            .startsWith(IMAGE_TYPE);
    }

    public List<Image> findAllByPostId(Long id) {
        return imageRepository.findAllByPostId(id);
    }
}