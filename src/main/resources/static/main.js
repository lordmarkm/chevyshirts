require.config({
  paths: {
    'angular': 'bower_components/angular/angular',
    'angular-animate': 'bower_components/angular-animate/angular-animate.min',
    'angular-ui-router': 'bower_components/angular-ui-router/release/angular-ui-router',
    'angular-resource': 'bower_components/angular-resource/angular-resource.min',
    'angular-ngtable': 'bower_components/ng-table/dist/ng-table.min',
    'angular-ui-select': 'bower_components/angular-ui-select/dist/select',
    'angular-sanitize': 'bower_components/angular-sanitize/angular-sanitize.min',
    'angular-bootstrap': 'bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
    'toaster': 'bower_components/angularjs-toaster/toaster',
    'bootstrap': 'bower_components/bootstrap/dist/js/bootstrap',
    'jquery': 'bower_components/jquery/dist/jquery.min',
    'metisMenu': 'bower_components/metisMenu/dist/metisMenu.min',
    'moment': 'bower_components/moment/min/moment.min',
    'angular-moment': 'bower_components/angular-moment/angular-moment.min'
  },
  shim: {
    'angular': {
      exports: 'angular',
      deps: ['jquery']
    },
    'angular-resource': {
      deps: ['angular']
    },
    'angular-ui-router': {
      deps: ['angular']
    },
    'angular-animate': {
      deps: ['angular']
    },
    'angular-ngtable': {
      deps: ['angular']
    },
    'angular-ui-select': {
      deps: ['angular']
    },
    'angular-sanitize': {
      deps: ['angular']
    },
    'angular-bootstrap': {
      deps: ['angular']
    },
    'angular-moment': {
      deps: ['angular', 'moment']
    },
    'toaster': {
      deps: ['angular']
    },
    'metisMenu': {
      deps: ['jquery']
    },
    'bootstrap': {
      deps: ['jquery']
    }
  }
});

require([
    'angular',
    'angular-resource',
    'angular-animate',
    'angular-ngtable',
    'angular-ui-select',
    'angular-sanitize',
    'angular-bootstrap',
    'toaster',
    'angular-ui-router',
    'jquery',
    'bootstrap',
    'metisMenu',
    'moment',
    'angular-moment',
    'core/core.module.js'
  ], function (angular) {
  angular.element().ready(function () {
    angular.bootstrap(document, [
      'ui.router',
      'ngResource',
      'ngAnimate',
      'ngTable',
      'ui.select',
      'ngSanitize',
      'ui.bootstrap',
      'toaster',
      'angularMoment',
      'core.module'
    ]);
  });
});