import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class LoginDoctorService {

  url="http://localhost:9091"

  constructor(private http:HttpClient) { }

  generateToken(credentials:any){
    return this.http.post(`${this.url}/token`,credentials)
    }

  loginUser(token: string)
  {
    localStorage.setItem("token",token)
    return true;
  }

  isLoggedIn()
{
  let token=localStorage.getItem("token");
  if(token==undefined || token==='' || token==null)
  {
    return false;
  }
  else
  {
    return true;
  }
}
//for logout the user
logout(){
  localStorage.removeItem('token');
  return true;
}
//for getting token
getToken()
{
  return localStorage.getItem("token")
}
getdoctors(){
  return this.http.get(`${this.url}/Getdoctor`)
}
getUsername(){
  return this.http.post(`${this.url}/doctor/token/get`,localStorage.getItem("token"))
}
getdoctorappointments(doctorname:any){
  return this.http.get(`${this.url}/doctorappointment/${doctorname}`)
}
}
