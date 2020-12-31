import { React, useEffect } from "react";
import { Route, withRouter } from "react-router-dom";
import "./App.css";
import UrlForm from "./components/UrlForm";

function App(props) {

  useEffect(() => {
    const slug = props.match.params.slug;

    fetch(`http://localhost:8088/slug/${slug}`)
      .then((res) => res.json())
      .then((data) => (window.location.href = data.url));
  }, [props.match.params.slug]);

  return (
    <div className="App">
      <Route path="/create-short-url" component={UrlForm}/>
    </div>
  );
}

export default withRouter(App);
