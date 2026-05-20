package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Tələbənin kursa qeydiyyat cavabı")
public class EnrollmentResponseDto {

    @Schema(
            description = "Qeydiyyatın unikal identifikatoru",
            example = "10"
    )
    private Long enrollmentId;

    @Schema(
            description = "Kursun ID-si",
            example = "1"
    )
    private Long courseId;

    @Schema(
            description = "Tələbənin ID-si",
            example = "15"
    )
    private Long studentId;

    @Schema(
            description = "Əməliyyat nəticəsi mesajı",
            example = "Tələbə uğurla kursa qeydiyyatdan keçdi"
    )
    private String message;

    @Schema(
            description = "Qeydiyyat tarixi və vaxtı",
            example = "2026-05-20T12:30:00"
    )
    private LocalDateTime enrollmentDate;
}