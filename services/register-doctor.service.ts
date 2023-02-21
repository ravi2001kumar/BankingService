import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterDoctorService {

  Url="http://localhost:9091";
  constructor(private  http:HttpClient) {  }

  doRegister(credentials:any)
  {
    return this.http.post(`${this.Url}/doctoradd`,credentials)
  }


  registerDoctor(doctoradd: string)
  {
    localStorage.setItem("doctoradd",doctoradd)
    return true;
  }
  isRegister()
  {
    let doctoradd=localStorage.getItem("doctoradd");
    if(doctoradd==undefined || doctoradd==='' || doctoradd==null)
    {
      return false;
    }else{
      return true;
    }
  }
}
