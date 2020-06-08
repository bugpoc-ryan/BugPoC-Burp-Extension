# BugPoC-Burp-Extension

Burp Suite Extension to send raw HTTP Requests to [BugPoC.com](https://bugpoc.com). Visit the [integration page](https://bugpoc.com/testers/other/burp) for more information.

## Why

[Burp Suite](https://portswigger.net/burp) is an amazing offensive security tool. It helps thousands of pentesters and bug bounty hunters all over the world find cool bugs. But your clients might not want to install fancy pentest tools just to reproduce your bug. BugPoC lets regular Software Developers repeat raw HTTP requests directly from their browser.

The BugPoC Burp Extension allows Burp Suite to export raw HTTP requests directly to the BugPoC [HTTP PoC Generator](https://bugpoc.com/testers/http). This will let you use Burp Suite's proxy to identify interesting HTTP requests then preserve them with BugPoC for easy reporting. Once loaded into BugPoC, you can modify and replay the HTTP request from within the browser, without any additional tools. 

## Quick Start

1. Download the Burp Extension JAR file.
1. Add the Extension to Burp using the steps found [here](https://portswigger.net/burp/documentation/desktop/tools/extender#loading-and-managing-extensions).
1. Sign-In to [BugPoC](https://bugpoc.com) as a Tester
1. In Burp, right click any HTTP request and click *"Send to BugPoC."*

![Screen Recording](https://github.com/bugpoc-ryan/BugPoC-Burp-Extension/raw/master/burp.gif)

You will now be able to edit and repeat this request from the BugPoC website. Once your PoC fully demonstrates your bug, you can publish it to receive a BugPoC ID and password. Include this ID and password in your bug report so your clients can quickly reproduce your bug without needing to install any tools or proxies. Trust us, Software Developers are going to love you for that. ❤️

