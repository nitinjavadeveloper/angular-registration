import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { UserService } from '../user.service';
export class MyErrorStateMatcher implements ErrorStateMatcher
{
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {

    const isSubmitted  = form && form.submitted;
    return !! (control && control.invalid && (control.dirty || control.touched ))
  }
  
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: any = {};
  empName :string;
  email:string;
  password :string;
  description:string;
  designation:string;

  emailFormControl = new FormControl(
    '',
    [
      Validators.required,
      Validators.email,
    ]);

    matcher = new MyErrorStateMatcher();
  constructor(private userService:UserService) { }

  ngOnInit(): void {

  }
  save()
  {
    this.userService.createUser(this.user)
    .subscribe( data =>console.log(data))
    alert('user created ')
    , error => console.log(error);
    
  }
}

