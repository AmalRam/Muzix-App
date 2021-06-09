import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('http://localhost:4200/muzix/search');
  }
   clickNavSuggestedMuzix(){
    return element(by.id('btn-nav-suggested-muzixs')).click();
  }
}