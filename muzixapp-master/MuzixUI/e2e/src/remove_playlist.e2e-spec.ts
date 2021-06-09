import { PlayListPage } from './remove_playlist.po';

import { browser,by,protractor,element } from "protractor";

describe('PlayList Page', () => {
    let page: PlayListPage;
    beforeEach(() => {
      page = new PlayListPage();
      browser.driver.manage().window().maximize();
    });


    it('Remove PlayList - Test01', ()=> {
        browser.sleep(5000);
        element(by.id('btn-nav-my-playlist')).click();
        browser.sleep(5000);
        element(by.id('btn-remove-from-playlist')).click();
        const EC4 = protractor.ExpectedConditions;   
        const snackBar3 = element(by.xpath('/html/body/div[2]'));
        
        browser.wait(EC4.visibilityOf(snackBar3), 5000);
        element(by.xpath('/html/body/div[2]')).getText().then(function (val3) {
           console.log(val3)  
           expect(val3).toEqual('Zoombai Warriors Surfing on a Small Chapati Sound in the East of Parvati - Megamix removed from playlist')
        });
     
       
    });


});