package az.edu.ada.wm2.courseservice.exception;

public class PrerequisiteNotSatisfiedException extends RuntimeException {

    public PrerequisiteNotSatisfiedException(Long prerequisiteId, Long courseId) {
        super("Student must complete prerequisite course with id "
                + prerequisiteId + " before enrolling in course " + courseId);
    }
}