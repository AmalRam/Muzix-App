import { AppPage } from './suggest.po';
import {browser} from 'protractor';

describe('Suggested Page ', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  
  it('testing Suggest  Page',()=> {
    page.clickNavSuggestedMuzix();
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/muzix/suggest');
    browser.sleep(5000);
  });

  

});
