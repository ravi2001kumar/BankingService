import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  static getToken() {
    throw new Error('Method not implemented.');
  }

  url="http://localhost:9092"

  constructor(private http:HttpClient) { }

  // calling the server to generate token

 generateToken(credentials:any){
  return this.http.post(`${this.url}/token`,credentials)
  }

  //for login user

loginUser(token: string)
{
  localStorage.setItem("token",token)
  return true;
}
//to check user login or not
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
getUser(){
  let user=localStorage.getItem("user");
  if(user=="patient"){
    return true;
  }
  else{
    return false;
  }
}
getpatients(){
  return this.http.get(`${this.url}/Getpatients`)
}

getUsername(){
  return this.http.post(`${this.url}/patient/token/get`,localStorage.getItem("token"))
}
}
