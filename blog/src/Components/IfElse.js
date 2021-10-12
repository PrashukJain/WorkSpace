import React, { Component } from 'react'

export default class IfElse extends Component {
    constructor(){
        super()
        this.state={
            isloggedin:true
        }
    }
    render() {
    
         return    this.state.isloggedin?
            (<div>Welocome Prashuk</div>):(<div>Welcome Guest</div>)
        
        
    }
}
