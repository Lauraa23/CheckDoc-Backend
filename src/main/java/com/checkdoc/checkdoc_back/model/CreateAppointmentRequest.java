package com.checkdoc.checkdoc_back.model;

import java.time.LocalDateTime;


public class CreateAppointmentRequest {
    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentDate;


    public Long getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
