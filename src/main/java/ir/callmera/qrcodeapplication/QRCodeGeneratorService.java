package ir.callmera.qrcodeapplication;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGeneratorService {

    public static void generateQRCodeImage(GenerateQRCodeRequestDTO generateQRCodeRequestDTO, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                generateQRCodeRequestDTO.getContent(),
                BarcodeFormat.QR_CODE,
                generateQRCodeRequestDTO.getWidth(),
                generateQRCodeRequestDTO.getHeight()
        );
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static byte[] getQRCodeImage(GenerateQRCodeRequestDTO generateQRCodeRequestDTO) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                generateQRCodeRequestDTO.getContent(),
                BarcodeFormat.QR_CODE,
                generateQRCodeRequestDTO.getWidth(),
                generateQRCodeRequestDTO.getHeight()
        );
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        byte[] result = outputStream.toByteArray();
        return result;
    }
}
