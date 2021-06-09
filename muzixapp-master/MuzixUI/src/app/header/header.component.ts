import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../modules/authentication/auth-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'mcapp-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthenticationService,private router: Router) { }

  ngOnInit() {
  }

  logout(){
    this.authService.deleteToken();
    this.router.navigate(['/login']);
  }

}
