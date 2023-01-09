import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerProductsComponent } from './customer-products/customer-products.component';
import { CustomerUpdateComponent } from './customer-update/customer-update.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { path: '', redirectTo: "signin", pathMatch: 'full' },
  { path: 'signin', component: SignInComponent },
  // { path: 'customer/:user/:pass', component: CustomerProductsComponent },
  { path: 'customer', component: CustomerProductsComponent },
  { path: "update/:id", component: CustomerUpdateComponent },
  { path: 'signup', component: SignUpComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
