package model.bean;

import oracle.adf.view.rich.event.DialogEvent;

public class TeacherBean {
    public TeacherBean() {
    }

    public void deleteTeacherDialogueListener(DialogEvent dialogEvent) {
       MyADFUtil.executeOperation("Delete");
       MyADFUtil.executeOperation("Commit");
       MyADFUtil.showErrorMessage("Teacher Delete Successfully");
    }
}
