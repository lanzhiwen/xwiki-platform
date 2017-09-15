/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
require.config({
  paths: {
    'xwiki-selectize': "$xwiki.getSkinFile('uicomponents/suggest/xwiki.selectize.js', true)" +
      "?v=$escapetool.url($xwiki.version)"
  }
});

require(['jquery', 'xwiki-selectize'], function($) {
  'use strict';

  var getSelectizeOptions = function(select) {
    var loadURL = [
      '$request.contextPath', 'rest',
      'wikis', encodeURIComponent(XWiki.currentWiki),
      'classes', encodeURIComponent(select.attr('data-className')),
      'properties', encodeURIComponent(select.attr('data-propertyName')),
      'values'
    ].join('/');
    return {
      create: true,
      load: function(text, callback) {
        $.getJSON(loadURL, {
          'fp': text,
          'limit': 10
        }).then(function(response) {
          if (response && $.isArray(response.propertyValues)) {
            return response.propertyValues.map(getSuggestion);
          } else {
            return [];
          }
        }).done(callback).fail(callback);
      }
    };
  };

  var getSuggestion = function(propertyValue) {
    var metaData = propertyValue.metaData || {};
    return {
      value: propertyValue.value,
      label: metaData.label,
      icon: metaData.icon
    };
  };

  $.fn.suggestPropertyValues = function() {
    return this.each(function() {
      $(this).xwikiSelectize(getSelectizeOptions($(this)));
    });
  };

  $('.suggest-propertyValues').suggestPropertyValues();
});
