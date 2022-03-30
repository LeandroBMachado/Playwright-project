package support.azure.model.attachment;



import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import support.dates.DatePicker;
import static support.context.Context.*;


@Getter @Setter
public class Attachment {

    private String stream;
    private String fileName;
    private String comment;
    private String attachmentType;

    public Attachment(String extension ,String comment) {
        this.stream = new String(Base64.encodeBase64(web().getPage().screenshot()));
        this.fileName = String.format("Evidence_%s_%s.%s",
                DatePicker.getCurrentDate().replace("/",""),
                DatePicker.getCurrentTime().replace(":",""),extension);
        this.comment = comment;
        this.attachmentType = "GeneralAttachment";
    }

    public Attachment(String extension,String value,String comment) {
        this.stream = new String(Base64.encodeBase64(value.getBytes()));
        this.fileName = String.format("Evidence_%s_%s.%s",
                DatePicker.getCurrentDate().replace("/",""),
                DatePicker.getCurrentTime().replace(":",""),extension);
        this.comment = comment;
        this.attachmentType = "GeneralAttachment";
    }
}
