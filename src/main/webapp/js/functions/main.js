require
		.config({
			baseUrl : 'js',
			paths : {
				jquery : 'jquery-1.7.1.min',
				underscore : 'underscore',
				backbone : 'backbone',
				bootstrap : 'bootstrap',
				easyui : 'jquery.easyui.min',
				app : 'app'
			},
			shim : {
				underscore : {
					exports : '_'
				},
				backbone : {
					deps : [ 'underscore', 'jquery' ],
					exports : 'Backbone'
				},
				easyui : {
					deps : [ 'jquery' ]
				},
				app : {
					deps : [ 'underscore', 'jquery', 'backbone', 'bootstrap',
							'easyui' ]
				}
			}
		});

require([ 'jquery', 'underscore', 'backbone', 'bootstrap', 'easyui', 'app' ],
		function($, _, Backbone) {
			var router = Backbone.Router.extend({
				routes : {
					'changeview/:name' : 'changeview'
				},

				changeview : function(name) {
					if (name) {

					} else {

					}
				}
			});
		});
