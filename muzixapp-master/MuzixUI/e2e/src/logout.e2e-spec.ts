
import { browser,by,protractor,element } from "protractor";

describe('Search Page', () => {
   
    beforeEach(() => {
    
      browser.driver.manage().window().maximize();
    });

it('Muzix App- Logout Test', async()=>
{ 
 element(by.xpath("/html/body/app-root/mcapp-header/nav/ul/li[5]/a")).click();
 expect<any>(browser.getCurrentUrl()).toEqual("http://localhost:4200/login"); 
});
}); 