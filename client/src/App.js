import logo from './logo.svg';
import './App.css';
import {Button, Col, Container, Dropdown, DropdownItem, DropdownMenu, DropdownToggle, Row} from "reactstrap";
import {useState} from "react";
import axios from "axios";

function App() {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const [selection, setSelection] = useState('');
  const [template, setTemplate] = useState({});
  const toggle = () => setDropdownOpen((prevState) => !prevState);
  const options = [1200, 1500, 1800, 2000, 2500];

  const getMealPlan = async() => {
    // const res = await fetch('meal?calories=2000');
    // const data = await res.json();
    // console.log(data);
    // setTemplate(data);
    const res = await axios.get('meal' , {params: { calories: selection}});
    console.log(res.data);
    setTemplate(res.data);
  }

  return (
      <Container>

        <h1>Welcome Someone</h1>
        <p>Please select the caloric intake that best matches your lifestyle</p>
        <Row>
          <Col xs="auto">
            <Dropdown isOpen={dropdownOpen} toggle={toggle}>
              <DropdownToggle
                  caret>{selection === '' ? 'Desired Caloric Intake' : `${selection} Calories`}</DropdownToggle>
              <DropdownMenu>
                {options.map(value => (
                    <DropdownItem key={value} onClick={() => setSelection(value)}>{value} Calories</DropdownItem>
                ))}
              </DropdownMenu>
            </Dropdown>
          </Col>
          <Col>
            <Button onClick={() => getMealPlan()}>View Plan</Button>
          </Col>
        </Row>


      </Container>
  );
}

export default App;
