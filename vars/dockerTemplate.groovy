#!/usr/bin/groovy
@groovy.transform.Field 
String label="mypod"
def call(body) {
  podTemplate(label: label,
        containers: [containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true)],
        volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]) {
    body()
  }
}
