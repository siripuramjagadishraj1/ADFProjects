package model.bean;

import oracle.adf.view.rich.event.DialogEvent;

public class StudentBean {
    public StudentBean() {
    }

    public void studentDeleteListener(DialogEvent dialogEvent) {
        MyADFUtil.executeOperation("Delete");
        MyADFUtil.executeOperation("Commit");
        MyADFUtil.showErrorMessage("Student Delete Successfully");
    }
}
