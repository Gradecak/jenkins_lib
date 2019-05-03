#!/usr/bin/env groovy

def call(String buildResult) {
    if ( buildResult == "SUCCESS" ) {
        slackSend(color: "good", message: "Job: ${env.JOB_NAME}-${env.BUILD_NUMBER} was successful!")
    }
    else if( buildResult == "FAILURE" ) {
        slackSend(color: "danger", message: "Job: ${env.JOB_NAME}-${env.BUILD_NUMBER} failed!")
    }
    else if( buildResult == "UNSTABLE" ) {
        slackSend(color: "warning", message: "Job: ${env.JOB_NAME}-${env.BUILD_NUMBER} is unstable.")
    }
    else if (buildResult == "STARTED") {
        slackSend(color: "ff9900", message: "Job: ${env.JOB_NAME}-${env.BUILD_NUMBER} started...")
    }
    else {
        slackSend(color: "danger", message: "Job: ${env.JOB_NAME}-${env.BUILD_NUMBER} result unclear")
    }
}
