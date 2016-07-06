package com.message

class RefinerController {

    def index() {
        render(view: "index")
    }

    def test1() {
        redirect(uri: "/?value=<script>alert(101);</script>")
    }
}
