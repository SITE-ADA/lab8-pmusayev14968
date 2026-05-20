package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Kurs cavab məlumatı (API response)")
public class CourseResponseDto {

    @Schema(
            description = "Kursun unikal identifikatoru",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Kursun adı",
            example = "Data Structures"
    )
    private String title;

    @Schema(
            description = "Kurs kodu",
            example = "CS201"
    )
    private String code;

    @Schema(
            description = "Kredit sayı",
            example = "4"
    )
    private Integer credits;

    @Schema(
            description = "Prerequisite kursun ID-si (əgər varsa)",
            example = "1",
            nullable = true
    )
    private Long prerequisiteId;
}