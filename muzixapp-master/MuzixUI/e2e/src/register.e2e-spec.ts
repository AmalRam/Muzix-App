
import { browser,by,protractor } from "protractor";
describe('Register Page Testing',function(){
it('To check the page title',function(){
  
    browser.get("http://localhost:4200/register").then(()=>(browser.getTitle())).then((title)=>(console.log(title)));
})
it('Register User', async()=>  {
    browser.get("http://localhost:4200/register");
    browser.driver.manage().window().maximize();
   browser.driver.sleep(4000); 
   browser.findElement(by.id('firstName')).sendKeys("test33");
   browser.findElement(by.id('lastName')).sendKeys("test33");
   browser.findElement(by.id('userId')).sendKeys("test33");
   browser.findElement(by.id('password')).sendKeys("test33");
   browser.findElement(by.id('register')).click(); 
   browser.sleep(2000);
    expect(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
   browser.driver.sleep(5000);
    })


   it('Registering with exiting credentials ', async()=>  {
     browser.get("http://localhost:4200/register");
     browser.driver.manage().window().maximize();
     browser.driver.sleep(4000); 
     browser.findElement(by.id('firstName')).sendKeys("test33");
     browser.findElement(by.id('lastName')).sendKeys("test33");
     browser.findElement(by.id('userId')).sendKeys("test33");
     browser.findElement(by.id('password')).sendKeys("test33");
     browser.findElement(by.xpath('/html/body/app-root/app-register/form/div/div[3]/button[1]/span')).click();
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
     browser.driver.sleep(5000);
    })

   it('Reset Button Working', async()=>{
    browser.get("http://localhost:4200/register");
    browser.driver.manage().window().maximize();
    browser.driver.sleep(4000); 
    browser.element(by.id('firstName')).sendKeys("test26");
    browser.element(by.id('lastName')).sendKeys("test26");
    browser.element(by.id('userId')).sendKeys("test26");
    browser.element(by.id('password')).sendKeys("test26");
    browser.driver.sleep(2000);
    browser.element(by.xpath('/html/body/app-root/app-register/form/div/div[3]/button[2]')).click();
    var EC = protractor.ExpectedConditions;
    const resetButton=browser.element(by.xpath('/html/body/app-root/app-register/form/div/div[3]/button[2]'));
    browser.wait(EC.elementToBeClickable(resetButton), 5000);
   });
})