import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  Url="http://localhost:9092";

  constructor(private  http:HttpClient){}

  doBookAppointment(credentials:any)
  {
    return this.http.post(`${this.Url}/BookAppointment`,credentials)
  }
  // to book appointment
   bookappointment(BookAppointment: string)
  {
    localStorage.setItem("BookAppointment",BookAppointment)
    return true;
  }
  isBookAppointment()
  {
    let BookAppointment=localStorage.getItem("BookAppointment");
    if(BookAppointment==undefined || BookAppointment==='' || BookAppointment==null)
    {
      return false;
    }else{
      return true;
    }
  }
  getBookAppointment()
  {
    return localStorage.getItem("BookAppointment")
  }
}
