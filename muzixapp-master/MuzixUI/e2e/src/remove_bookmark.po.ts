import {browser,element,by,protractor} from 'protractor';
export class BookmarkPage { 

    public baseUrl ='http://localhost:4200/muzix/bookmark';
    navigateTo(): any
  {
    browser.ignoreSynchronization= true;
   // browser.waitForAngularEnabled;
    return browser.get(this.baseUrl);
  }


  
}