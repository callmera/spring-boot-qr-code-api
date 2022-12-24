package ir.callmera.qrcodeapplication;

import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1")
public class QRCodeGeneratorController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @GetMapping("/download")
    public void download(@RequestBody GenerateQRCodeRequestDTO requestDTO) throws IOException, WriterException {
        QRCodeGeneratorService.generateQRCodeImage(
                requestDTO,
                QR_CODE_IMAGE_PATH
        );
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody GenerateQRCodeRequestDTO requestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGeneratorService.getQRCodeImage(requestDTO));
    }
}
