import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
signup: FormGroup  ;
usrnm: any;
name: any;
passwd:any;

uage:any;
ugender:any;
umail:any;
ucity:any;

  constructor(private route: Router,public formBuilder: FormBuilder) { 
    this.signup = this.formBuilder.group({
      name:['',[Validators.required, Validators.minLength(3), Validators.maxLength(15), Validators.pattern("[a-zA-Z ]*")]],
      user:['',[Validators.required,Validators.pattern("/^[a-z0-9._%+-]+@[miraclesoft]+\.com*$/")]],
     
      pwd:['',[Validators.required,Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
      age:['',[Validators.required,Validators.pattern("^[0-9]*$")]],
      gender:['',[Validators.required]],
      city:['',[Validators.required]],
      price:['',[Validators.required,Validators.pattern("^[0-9]*$")]],
    
      



    })
  }

  ngOnInit(): void {
  }

}
