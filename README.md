
Thymeleaf Bootstrap dialect
===========================

This is a draft of a Twitter's Bootstrap Thymeleaf dialect.

For now, it only allows to generate Nav (tabs and pills) using custom Thymeleaf tags.

Requirements
------------

 - Java 6
 - Thymeleaf 2.0.15


Installation
------------

TODO

Usage
-----

### Nav tabs

    <bootstrap:nav type="tabs">
        <tab id="demo" label="First tab" active="true">
            any content here : plain text, HTML tags (even if they need to be processed by Thymeleaf !)
        </tab>
        <tab id="id" label="Second tab">
            any content here too !
        </tab>
    </bootstra:nav>

### Nav tabs

Just replace the <code>type</code> attribute value by <tt>pills</tt> !

    <bootstrap:nav type="pills">

