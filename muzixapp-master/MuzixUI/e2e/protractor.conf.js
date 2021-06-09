// Protractor configuration file, see link for more information
// https://github.com/angular/protractor/blob/master/lib/config.ts

const { SpecReporter } = require('jasmine-spec-reporter');

exports.config = {
  allScriptsTimeout: 50000,
  specs: [
   './src/**/register.e2e-spec.ts',
    './src/**/login.e2e-spec.ts',
    './src/**/search.e2e-spec.ts',
   './src/**/remove_playlist.e2e-spec.ts',
  './src/**/remove_bookmark.e2e-spec.ts',
  './src/**/defect_findings.e2e-spec.ts',
  './src/**/suggest.e2e-spec.ts',
  './src/**/logout.e2e-spec.ts',
   
  ],
  capabilities: {
    'browserName': 'chrome'
  },
  directConnect: true,
  baseUrl: 'http://localhost:4200/',
  framework: 'jasmine',
  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 30000,
    print: function() {}
  },
  onPrepare() {
    require('ts-node').register({
      project: require('path').join(__dirname, './tsconfig.e2e.json')
    });
    jasmine.getEnv().addReporter(new SpecReporter({ spec: { displayStacktrace: true } }));
  }
};