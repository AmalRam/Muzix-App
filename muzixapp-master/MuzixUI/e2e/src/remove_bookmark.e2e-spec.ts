import { BookmarkPage } from './remove_bookmark.po';

import { browser,by,protractor,element } from "protractor";

describe('BookMark Page', () => {
    let page: BookmarkPage;
    beforeEach(() => {
      page = new BookmarkPage();
      browser.driver.manage().window().maximize();
    });


    it('Remove Bookmark - Test01', ()=> {
        browser.sleep(5000);
        element(by.id('btn-nav-my-bookmark')).click();
        browser.sleep(5000);
        element(by.id('btn-remove-from-bookmark')).click();
        const EC3 = protractor.ExpectedConditions;   
        const snackBar2 = element(by.xpath('/html/body/div[2]'));
        
        browser.wait(EC3.visibilityOf(snackBar2), 5000);
        element(by.xpath('/html/body/div[2]')).getText().then(function (val) {
           console.log(val)  
           expect(val).toEqual('Ice Cream (with Selena Gomez) deleted from Bookmark')
       
        });
     
       
    });


});