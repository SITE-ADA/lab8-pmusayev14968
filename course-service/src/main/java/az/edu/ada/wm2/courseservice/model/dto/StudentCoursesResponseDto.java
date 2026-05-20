package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Tələbəyə görə kursların siyahısı")
public record StudentCoursesResponseDto(

        @Schema(
                description = "Tələbənin unikal identifikatoru",
                example = "1"
        )
        Long studentId,

        @Schema(
                description = "Tələbənin adı",
                example = "Nicat"
        )
        String firstName,

        @Schema(
                description = "Tələbənin soyadı",
                example = "Əliyev"
        )
        String lastName,

        @Schema(
                description = "Tələbənin qeydiyyatda olduğu kurslar"
        )
        List<CourseResponseDto> courses
) {
}