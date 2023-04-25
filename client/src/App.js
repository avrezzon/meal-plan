import logo from "./logo.svg";
import "./App.css";
import {
  Button,
  ButtonGroup,
  Card,
  CardBody,
  CardHeader,
  CardText,
  CardTitle,
  Col,
  Container,
  Row,
} from "reactstrap";
import { MEAL_PLAN } from "./mock-data/meal-plan";
import { useState } from "react";
import {DayView} from "./components/DayView";

function App() {
  const mealplan = MEAL_PLAN;
  const [rSelected, setRSelected] = useState(1);
  const [viewSelected, setViewSelected] = useState("today"); //  today, tomorrow, or week


  return (
    <Container>
      <Row>
        <Col className="bg-light border">
          <h2 align="center">Meal Planner</h2>
        </Col>
      </Row>
      <br />
      <Row>
        <ButtonGroup>
          <Button
            color="primary"
            outline
            onClick={() => setRSelected(1)}
            active={rSelected === 1}
          >
            Today's Meals
          </Button>
          <Button
            color="primary"
            outline
            onClick={() => setRSelected(2)}
            active={rSelected === 2}
          >
            Tomorrow's Meals
          </Button>
          <Button
            color="primary"
            outline
            onClick={() => setRSelected(3)}
            active={rSelected === 3}
          >
            This Week's Meals
          </Button>
        </ButtonGroup>
      </Row>
      <br/>
        <Row><Col>Meals for April 21, 2023</Col></Row>
      <br />
      <DayView meals={mealplan}/>
    </Container>
  );
}

export default App;
