import {browser,element,by,protractor} from 'protractor';
export class PlayListPage { 

    public baseUrl ='http://localhost:4200/muzix/playlist';
    navigateTo(): any
  {
    browser.ignoreSynchronization= true;
   // browser.waitForAngularEnabled;
    return browser.get(this.baseUrl);
  }


  
}