import {
  AccordionBody,
  AccordionHeader,
  AccordionItem,
  Container,
  Row,
  UncontrolledAccordion,
} from "reactstrap";
import { MealView } from "./MealView";

export const DayView = (props) => {
  const mealTypes = props.meals.map((meal, index) => (
    <AccordionItem key={`${index}-${meal.name}-item`}>
      <AccordionHeader targetId={index.toString()}>{meal.name}</AccordionHeader>
      <AccordionBody accordionId={index.toString()}>
        <Container>
          <Row>
            <MealView key={`${meal.name}-view`} meal={meal}/>
          </Row>
        </Container>
      </AccordionBody>
    </AccordionItem>
  ));

  return (
    <UncontrolledAccordion defaultOpen={["1", "2"]} stayOpen>
      {mealTypes}
    </UncontrolledAccordion>
  );
};
