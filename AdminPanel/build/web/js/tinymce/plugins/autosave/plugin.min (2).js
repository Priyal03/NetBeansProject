tinymce.PluginManager.add("autosave",function(e){function t(e,t){var n={s:1e3,m:6e4};return e=/^(\d+)([ms]?)$/.exec(""+(e||t)),(e[2]?n[e[2]]:1)*parseInt(e,10)}function n(){var e=parseInt(m.getItem(f+"autosave.time"),10)||0;return(new Date).getTime()-e>d.autosave_retention?(i(),!1):!0}function i(){m.removeItem(f+"autosave.draft"),m.removeItem(f+"autosave.time")}function o(){u&&e.isDirty()&&(m.setItem(f+"autosave.draft",e.getContent({format:"raw",no_events:!0})),m.setItem(f+"autosave.time",(new Date).getTime()),e.fire("StoreDraft"))}function a(){n()&&(e.setContent(m.getItem(f+"autosave.draft"),{format:"raw"}),i(),e.fire("RestoreDraft"))}function r(){u||(setInterval(function(){e.removed||o()},d.autosave_interval),u=!0)}function s(){var t=this;t.disabled(!n()),e.on("StoreDraft RestoreDraft",function(){t.disabled(!n())}),r()}function l(){e.undoManager.beforeChange(),a(),e.undoManager.add()}function c(){var e;return tinymce.each(tinymce.editors,function(t){t.plugins.autosave&&t.plugins.autosave.storeDraft(),!e&&t.isDirty()&&t.getParam("autosave_ask_before_unload",!0)&&(e=t.translate("You have unsaved changes are you sure you want to navigate away?"))}),e}var u,d=e.settings,m=tinymce.util.LocalStorage,f=e.id;d.autosave_interval=t(d.autosave_interval,"30s"),d.autosave_retention=t(d.autosave_retention,"20m"),e.addButton("restoredraft",{title:"Restore last draft",onclick:l,onPostRender:s}),e.addMenuItem("restoredraft",{text:"Restore last draft",onclick:l,onPostRender:s,context:"file"}),this.storeDraft=o,window.onbeforeunload=c});