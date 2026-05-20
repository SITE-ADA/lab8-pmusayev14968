package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Kurs yaratmaq və ya yeniləmək üçün istifadə olunan məlumatlar")
public class CourseRequestDto {

    @Schema(
            description = "Kursun adı",
            example = "Data Structures"
    )
    @NotBlank(message = "Ad boş ola bilməz")
    private String title;

    @Schema(
            description = "Kurs kodu",
            example = "CS201"
    )
    @NotBlank(message = "Kod boş ola bilməz")
    private String code;

    @Schema(
            description = "Kredit sayı",
            example = "4"
    )
    @Positive(message = "Kredit müsbət olmalıdır")
    private Integer credits;

    @Schema(
            description = "Prerequisite kursun ID-si (opsional, null ola bilər)",
            example = "1"
    )
    private Long prerequisiteId;
}