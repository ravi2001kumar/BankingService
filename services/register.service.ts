import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  static getToken() {
    throw new Error('Method not implemented.');
  }

  Url="http://localhost:9092";
  
  constructor(private  http:HttpClient){}


  doRegister(credentials:any)
  {
    return this.http.post(`${this.Url}/patientsadd`,credentials)
  }

  // for registerpatient
  registerPatient(patientsadd: string)
  {
    localStorage.setItem("patientsadd",patientsadd)
    return true;
  }
  isRegister()
  {
    let patientsadd=localStorage.getItem("patientsadd");
    if(patientsadd==undefined || patientsadd==='' || patientsadd==null)
    {
      return false;
    }else{
      return true;
    }
  }
  

}

