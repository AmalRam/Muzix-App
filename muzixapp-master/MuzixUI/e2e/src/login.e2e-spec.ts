import { LoginPage } from './login.po';
import { element, by, browser, protractor } from 'protractor';

describe('Muzix App', () => {
  let page: LoginPage;
  beforeEach(() => {
    page = new LoginPage();
    page.navigateTo();
    browser.driver.manage().window().maximize();
  });
  /*it('should display Muzix as application title', () => {
    let spanElement = element(by.css('span')).getText();
    expect(spanElement).toEqual('My BookMarks');
  });*/
  it('InValid Login Test01', async()=>
     {
      page.setusername("vijay");
      page.setPassword("vijay");
      page.clickOnLoginButton();
      browser.sleep(5000);
      expect<any>(browser.getCurrentUrl()).toEqual("http://localhost:4200/login");
    });

  it('Valid Login Test02', async()=>
    {
    
     page.setusername("test33");
     page.setPassword("test33");
     page.clickOnLoginButton();
     browser.sleep(5000);
     expect<any>(browser.getCurrentUrl()).toEqual("http://localhost:4200/muzix/search");
    });
  
     

});