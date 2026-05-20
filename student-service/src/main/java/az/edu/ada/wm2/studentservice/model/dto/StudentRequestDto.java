package az.edu.ada.wm2.studentservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Tələbə yaratmaq və ya yeniləmək üçün istifadə olunan məlumatlar")
public class StudentRequestDto {

    @Schema(
            description = "Tələbənin adı",
            example = "Nicat"
    )
    @NotBlank(message = "Ad boş ola bilməz")
    private String firstName;

    @Schema(
            description = "Tələbənin soyadı",
            example = "Əliyev"
    )
    @NotBlank(message = "Soyad boş ola bilməz")
    private String lastName;

    @Schema(
            description = "Tələbənin e-mail ünvanı",
            example = "nicat.aliyev@example.com"
    )
    @NotBlank(message = "Email boş ola bilməz")
    @Email(message = "Email formatı düzgün deyil")
    private String email;

    @Schema(
            description = "Tələbənin yaşı (minimum 16)",
            example = "20",
            minimum = "16"
    )
    @Min(value = 16, message = "Yaş ən az 16 olmalıdır")
    private Integer age;
}